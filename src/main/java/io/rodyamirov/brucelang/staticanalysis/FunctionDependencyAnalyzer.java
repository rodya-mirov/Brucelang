package io.rodyamirov.brucelang.staticanalysis;

import io.rodyamirov.brucelang.ast.ASTNode;
import io.rodyamirov.brucelang.ast.BinOpExprNode;
import io.rodyamirov.brucelang.ast.BlockStatementNode;
import io.rodyamirov.brucelang.ast.BoolExprNode;
import io.rodyamirov.brucelang.ast.DoStatementNode;
import io.rodyamirov.brucelang.ast.FunctionCallNode;
import io.rodyamirov.brucelang.ast.FunctionDeclarationNode;
import io.rodyamirov.brucelang.ast.FunctionDefinitionNode;
import io.rodyamirov.brucelang.ast.IfStatementNode;
import io.rodyamirov.brucelang.ast.IntExprNode;
import io.rodyamirov.brucelang.ast.ParameterNode;
import io.rodyamirov.brucelang.ast.ProgramNode;
import io.rodyamirov.brucelang.ast.ReturnStatementNode;
import io.rodyamirov.brucelang.ast.StatementNode;
import io.rodyamirov.brucelang.ast.StringExprNode;
import io.rodyamirov.brucelang.ast.UnaryOpExprNode;
import io.rodyamirov.brucelang.ast.VariableDeclarationNode;
import io.rodyamirov.brucelang.ast.VariableDefinitionNode;
import io.rodyamirov.brucelang.ast.VariableReferenceNode;
import io.rodyamirov.brucelang.util.collections.ArrayStack;
import io.rodyamirov.brucelang.util.collections.ConsList;
import io.rodyamirov.brucelang.util.collections.Stack;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * This sweeps through the program and analyzes dependencies. It can detect circularity and either
 * - Detect circularity (outputting an example cycle)
 * - Determine the longest cost path from root to leaf (and output that path)
 */
public class FunctionDependencyAnalyzer {
    // populated by the DependencyVisitor
    private final DependencyGraph dependencyGraph = new DependencyGraph();

    public FunctionDependencyAnalyzer(ProgramNode programNode) {
        new DependencyVisitor().visitProgram(programNode);
    }

    public Path findWorstPath(String rootFunction) {
        List<SourceNodeData> sortedTopologically = new ArrayList<>();
        Map<String, Path> worstPaths = new HashMap<>();

        if (dependencyGraph.sourceNodes.contains(rootFunction)) {
            SourceNodeData sourceNode = dependencyGraph.removeSourceNode(rootFunction);
            sortedTopologically.add(sourceNode);
            // TODO: 0 is probably not the ACTUAL cost of running `main` but we're just counting method calls for now
            worstPaths.put(rootFunction, new Path(ConsList.empty(), 0));
        } else {
            // TODO: error messages
            String msg = String.format("Error: function '%s' is not a root node!", rootFunction);
            throw new RuntimeException(msg);
        }

        while (!dependencyGraph.sourceNodes.isEmpty()) {
            SourceNodeData sourceNode = dependencyGraph.removeSourceNode();
            sortedTopologically.add(sourceNode);
        }

        if (!dependencyGraph.allNodes.isEmpty()) {
            // TODO: find the cycle
            throw new RuntimeException("Cycle detected! Somewhere in this blob:" + Arrays.toString(dependencyGraph.allNodes.toArray()));
        }

        for (SourceNodeData node : sortedTopologically) {
            Path worstSoFar = worstPaths.get(node.sourceName);
            if (worstSoFar == null) {
                continue; // can't reach this node from the root, so paths from it are irrelevant
            }

            for (Map.Entry<String, Integer> outgoingEdge : node.outgoingWorstEdges.entrySet()) {
                String nextNode = outgoingEdge.getKey();
                Integer stepCost = outgoingEdge.getValue();

                Path existingWorstPath = worstPaths.get(nextNode);
                if (existingWorstPath == null || existingWorstPath.totalCost < worstSoFar.totalCost + stepCost) {
                    worstPaths.put(nextNode, worstSoFar.extend(nextNode, stepCost));
                }
            }
        }

        // return the worst path found
        Path worst = new Path(ConsList.empty(), 0);
        for (Path path : worstPaths.values()) {
            if (worst.totalCost < path.totalCost) {
                worst = path;
            }
        }
        return worst;
    }

    private static class SourceNodeData {
        public final String sourceName;
        public final Map<String, Integer> outgoingWorstEdges;

        public SourceNodeData(String sourceName, Map<String, Integer> outgoingWorstEdges) {
            this.sourceName = sourceName;
            this.outgoingWorstEdges = outgoingWorstEdges;
        }
    }

    public static class Path {
        public final ConsList<String> path;
        public final Integer totalCost;

        public Path(ConsList<String> path, Integer totalCost) {
            this.path = path;
            this.totalCost = totalCost;
        }

        public Path extend(String terminus, Integer stepCost) {
            return new Path(path.extend(terminus), this.totalCost + stepCost);
        }
    }

    public static class RecursionDetectedException extends Exception {
        private final List<String> cycle;

        public RecursionDetectedException(List<String> cycle) {
            super("Detected a circular dependency; this is not allowed!");
            this.cycle = cycle;
        }

        public List<String> getCycle() {
            return cycle;
        }
    }

    private class DependencyVisitor implements ASTNode.ASTVisitor {
        private final Stack<String> currentFunctionDefnStack = new ArrayStack<>();

        @Override
        public void visitProgram(ProgramNode programNode) {
            programNode.getStatements().forEach(node -> node.accept(this));
        }

        @Override
        public void visitFunctionDefinition(FunctionDefinitionNode functionDefinitionNode) {
            currentFunctionDefnStack.push(functionDefinitionNode.getFunctionDeclarationNode().getCanonicalName());
            functionDefinitionNode.getDefinitionStatement().accept(this);
            currentFunctionDefnStack.pop();

            functionDefinitionNode.getFunctionDeclarationNode().accept(this);
        }

        @Override
        public void visitVariableDefinition(VariableDefinitionNode variableDefinitionNode) {
            variableDefinitionNode.getEvalExpr().accept(this);
            variableDefinitionNode.getVariableDeclarationNode().accept(this);
        }

        @Override
        public void visitParameterNode(ParameterNode parameterNode) {
            // no op
        }

        @Override
        public void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
            // no op
        }

        @Override
        public void visitFunctionDeclaration(FunctionDeclarationNode functionDeclarationNode) {
            functionDeclarationNode.getParameters().forEach(node -> node.accept(this));
        }

        @Override
        public void visitBlockStatement(BlockStatementNode blockStatementNode) {
            blockStatementNode.getStatements().forEach(node -> node.accept(this));
        }

        @Override
        public void visitDoStatement(DoStatementNode doStatementNode) {
            doStatementNode.getEvalExpression().accept(this);
        }

        @Override
        public void visitReturnStatement(ReturnStatementNode returnStatementNode) {
            returnStatementNode.getEvalExpression().accept(this);
        }

        @Override
        public void visitIfStatement(IfStatementNode ifStatementNode) {
            ifStatementNode.getConditions().forEach(node -> node.accept(this));
            ifStatementNode.getResultingStatements().forEach(node -> node.accept(this));

            StatementNode elseNode = ifStatementNode.getElseStatement();
            if (elseNode != null) {
                elseNode.accept(this);
            }
        }

        @Override
        public void visitFunctionCallNode(FunctionCallNode functionCallNode) {
            dependencyGraph.addEdge(
                    currentFunctionDefnStack.peek(),
                    functionCallNode.getReference().getCanonicalName(),
                    1); // TODO: use actual costs? currently this just counts function calls

            functionCallNode.getArguments().forEach(node -> node.accept(this));
        }

        @Override
        public void visitBinOpExprNode(BinOpExprNode binOpExprNode) {
            binOpExprNode.getLeftChild().accept(this);
            binOpExprNode.getRightChild().accept(this);
        }

        @Override
        public void visitUnaryOpExprNode(UnaryOpExprNode unaryOpExprNode) {
            unaryOpExprNode.getChild().accept(this);
        }

        @Override
        public void visitIntExprNode(IntExprNode integerNode) {
            // no op
        }

        @Override
        public void visitBoolExprNode(BoolExprNode booleanNode) {
            // no op
        }

        @Override
        public void visitStringExprNode(StringExprNode stringExprNode) {
            // no op
        }

        @Override
        public void visitVariableReferenceNode(VariableReferenceNode variableReferenceNode) {
            // no op
        }
    }

    private static class DependencyGraph {
        private final Map<String, Map<String, Integer>> forwardEdges = new HashMap<>(); // edges from the key
        private final Map<String, Map<String, Integer>> reverseEdges = new HashMap<>(); // edges to the key

        private final Set<String> allNodes = new HashSet<>();
        private final Set<String> sourceNodes = new HashSet<>(); // nodes which have no incoming edges

        public DependencyGraph() {
        }

        private void ensureNodeDefined(String node) {
            if (!allNodes.contains(node)) {
                allNodes.add(node);
                sourceNodes.add(node);

                forwardEdges.put(node, new HashMap<>());
                reverseEdges.put(node, new HashMap<>());
            }
        }

        /**
         * Adds a new edge to the graph; if an existing edge is present, sets the cost of that edge
         * to the MAXIMUM of its existing cost or the cost of the new edge
         * @param source The beginning of the edge (function which does the calling)
         * @param terminus The end of the edge (function which is called)
         * @param cost Cost of the edge
         */
        public void addEdge(String source, String terminus, int cost) {
            ensureNodeDefined(source);
            ensureNodeDefined(terminus);

            Integer oldCost = forwardEdges.get(source).get(terminus); // nullable
            if (oldCost != null && oldCost >= cost) {
                return;
            }

            forwardEdges.get(source).put(terminus, cost);
            reverseEdges.get(terminus).put(source, cost);
        }

        /**
         * Removes a (random?) source node, updating the other data structures as appropriate
         * @return A source node which has been completely removed from the map, and all outgoing
         *          edges and weights from it
         * @throws NoSuchElementException if sourceNodes is empty
         */
        @Nonnull
        public SourceNodeData removeSourceNode() throws NoSuchElementException {
            Iterator<String> iterator = sourceNodes.iterator();
            String toRemove = iterator.next();
            iterator.remove();

            for (String terminus : forwardEdges.get(toRemove).keySet()) {
                reverseEdges.get(terminus).remove(toRemove);
            }

            allNodes.remove(toRemove);

            return new SourceNodeData(toRemove, forwardEdges.remove(toRemove));
        }

        /**
         * Removes a particular source node, updating the other data structures as appropriate
         * @param sourceNode The name of the node to remove
         * @return The map of all outgoing edges from sourceNode
         * @throws NoSuchElementException if there is no source node by this name
         */
        @Nonnull
        public SourceNodeData removeSourceNode(String sourceNode) throws NoSuchElementException {
            if (sourceNodes.contains(sourceNode)) {
                sourceNodes.remove(sourceNode);
            } else {
                throw new NoSuchElementException();
            }

            for (String terminus : forwardEdges.get(sourceNode).keySet()) {
                reverseEdges.get(terminus).remove(sourceNode);
            }

            allNodes.remove(sourceNode);

            return new SourceNodeData(sourceNode, forwardEdges.remove(sourceNode));
        }
    }
}
