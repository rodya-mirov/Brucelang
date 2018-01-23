package io.rodyamirov.brucelang;

public class Main {
    /*
    public static void main(String[] args) {
        CharStream input = CharStreams.fromString("(12+13*12)*2--12 + (1--(--2))");
        ExpressionLexer lexer = new ExpressionLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        ExpressionParser parser = new ExpressionParser(tokenStream);

        ExpressionParser.TopExprContext ctx;
        parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
        try {
            ctx = parser.topExpr();
        } catch (Exception e) {
            tokenStream.seek(0);
            parser.reset();
            parser.getInterpreter().setPredictionMode(PredictionMode.LL);
            ctx = parser.topExpr();
        }

        String outline = visit(new LispPrinter(), ctx);
        int result = visit(new EvalVisitor(), ctx);

        System.out.println(outline);
        System.out.println(result);
    }

    private static <T> T visit(ExpressionVisitor<T> visitor, ExpressionParser.TopExprContext ctx) {
        return visitor.visitTopExpr(ctx);
    }

    private static class LispPrinter extends AbstractParseTreeVisitor<String> implements ExpressionVisitor<String> {
        public String visitTopExpr(ExpressionParser.TopExprContext ctx) {
            return this.visitAddExpr(ctx.addExpr());
        }

        public String visitAddExpr(ExpressionParser.AddExprContext ctx) {
            int length = ctx.mulExpr().size();

            String start = visitMulExpr(ctx.mulExpr(0));

            for (int i = 1; i < length; i++) {
                String op = visitAddOp(ctx.addOp(i-1));
                String left = visitMulExpr(ctx.mulExpr(i));

                start = String.format("(%s %s %s)", op, left, start);
            }

            return start;
        }

        public String visitAddOp(ExpressionParser.AddOpContext ctx) {
            TerminalNode op; // here to enforce type checking
            if ((op = ctx.PLUS()) != null) {
                return "+";
            } else if ((op = ctx.MINUS()) != null) {
                return "-";
            } else {
                throw new RuntimeException("Unrecognized add operation: " + ctx.getText());
            }
        }

        public String visitMulExpr(ExpressionParser.MulExprContext ctx) {
            int length = ctx.unaryExpr().size();

            String start = visitUnaryExpr(ctx.unaryExpr(0));

            for (int i = 1; i < length; i++) {
                String op = visitMulOp(ctx.mulOp(i-1));
                String left = visitUnaryExpr(ctx.unaryExpr(i));

                start = String.format("(%s %s %s)", op, left, start);
            }

            return start;
        }

        public String visitMulOp(ExpressionParser.MulOpContext ctx) {
            TerminalNode op; // here to enforce type checking
            if ((op = ctx.TIMES()) != null) {
                return "*";
            } else if ((op = ctx.DIVIDE()) != null) {
                return "/";
            } else {
                throw new RuntimeException("Unrecognized multiplicative operation: " + ctx.getText());
            }
        }

        public String visitParenExpr(ExpressionParser.ParenExprContext ctx) {
            return this.visitTopExpr(ctx.topExpr());
        }

        public String visitUnaryExpr(ExpressionParser.UnaryExprContext ctx) {
            if (ctx instanceof ExpressionParser.FallThroughBaseExprContext) {
                return visitFallThroughBaseExpr((ExpressionParser.FallThroughBaseExprContext) ctx);
            } else if (ctx instanceof ExpressionParser.NestedUnaryExprContext) {
                return visitNestedUnaryExpr((ExpressionParser.NestedUnaryExprContext) ctx);
            } else {
                throw new RuntimeException("Unrecognized unary expression subtype: " + ctx.getClass().getName());
            }
        }

        public String visitNestedUnaryExpr(ExpressionParser.NestedUnaryExprContext ctx) {
            return String.format("(%s %s)", visitUnaryOp(ctx.unaryOp()), visitUnaryExpr(ctx.unaryExpr()));
        }

        public String visitUnaryOp(ExpressionParser.UnaryOpContext ctx) {
            TerminalNode op; // here to enforce type checking
            if ((op = ctx.MINUS()) != null) {
                return "-";
            } else {
                throw new RuntimeException("Unrecognized unary operation: " + ctx.getText());
            }
        }

        public String visitFallThroughBaseExpr(ExpressionParser.FallThroughBaseExprContext ctx) {
            return visitBaseExpr(ctx.baseExpr());
        }

        public String visitBaseExpr(ExpressionParser.BaseExprContext ctx) {
            if (ctx instanceof ExpressionParser.ParenExprContext) {
                return visitParenExpr((ExpressionParser.ParenExprContext) ctx);
            } else if (ctx instanceof ExpressionParser.NumberContext) {
                return visitNumber((ExpressionParser.NumberContext) ctx);
            } else {
                throw new RuntimeException("Unrecognized baseExpr variant: " + ctx.getClass().getName());
            }
        }

        public String visitNumber(ExpressionParser.NumberContext ctx) {
            return ctx.INT().getText();
        }
    }

    private static class EvalVisitor extends AbstractParseTreeVisitor<Integer> implements ExpressionVisitor<Integer> {
        private static final AtomicInteger opCounter = new AtomicInteger(0);
        private static final int PLUS_OP   = opCounter.incrementAndGet();
        private static final int MINUS_OP  = opCounter.incrementAndGet();
        private static final int TIMES_OP  = opCounter.incrementAndGet();
        private static final int DIVIDE_OP = opCounter.incrementAndGet();

        public Integer visitTopExpr(ExpressionParser.TopExprContext ctx) {
            return this.visitAddExpr(ctx.addExpr());
        }

        public Integer visitAddExpr(ExpressionParser.AddExprContext ctx) {
            int start = visitMulExpr(ctx.mulExpr(0));

            for (int i = 1; i < ctx.mulExpr().size(); i++) {
                int op = visitAddOp(ctx.addOp(i-1));
                int val = visitMulExpr(ctx.mulExpr(i));

                if (op == PLUS_OP) {
                    start += val;
                } else if (op == MINUS_OP) {
                    start -= val;
                } else {
                    throw new RuntimeException("Unrecognized additive operator: " + op);
                }
            }

            return start;
        }

        public Integer visitAddOp(ExpressionParser.AddOpContext ctx) {
            TerminalNode op; // here to enforce type checking
            if ((op = ctx.PLUS()) != null) {
                return PLUS_OP;
            } else if ((op = ctx.MINUS()) != null) {
                return MINUS_OP;
            } else {
                throw new RuntimeException("Unrecognized add operation: " + ctx.getText());
            }
        }

        public Integer visitMulExpr(ExpressionParser.MulExprContext ctx) {
            int start = visitUnaryExpr(ctx.unaryExpr(0));

            for (int i = 1; i < ctx.unaryExpr().size(); i++) {
                int op = visitMulOp(ctx.mulOp(i-1));
                int val = visitUnaryExpr(ctx.unaryExpr(i));

                if (op == TIMES_OP) {
                    start *= val;
                } else if (op == DIVIDE_OP) {
                    start /= val;
                } else {
                    throw new RuntimeException("Unrecognized operation type: " + op);
                }
            }

            return start;
        }

        public Integer visitMulOp(ExpressionParser.MulOpContext ctx) {
            TerminalNode op; // here to enforce type checking
            if ((op = ctx.TIMES()) != null) {
                return TIMES_OP;
            } else if ((op = ctx.DIVIDE()) != null) {
                return DIVIDE_OP;
            } else {
                throw new RuntimeException("Unrecognized multiplicative operation: " + ctx.getText());
            }
        }

        public Integer visitParenExpr(ExpressionParser.ParenExprContext ctx) {
            return this.visitTopExpr(ctx.topExpr());
        }

        public Integer visitUnaryExpr(ExpressionParser.UnaryExprContext ctx) {
            if (ctx instanceof ExpressionParser.FallThroughBaseExprContext) {
                return visitFallThroughBaseExpr((ExpressionParser.FallThroughBaseExprContext) ctx);
            } else if (ctx instanceof ExpressionParser.NestedUnaryExprContext) {
                return visitNestedUnaryExpr((ExpressionParser.NestedUnaryExprContext) ctx);
            } else {
                throw new RuntimeException("Unrecognized unary expression subtype: " + ctx.getClass().getName());
            }
        }

        public Integer visitNestedUnaryExpr(ExpressionParser.NestedUnaryExprContext ctx) {
            int op = visitUnaryOp(ctx.unaryOp());
            int val = visitUnaryExpr(ctx.unaryExpr());

            if (op == MINUS_OP) {
                return -val;
            } else {
                throw new RuntimeException("Unrecognized unary operation: " + op);
            }
        }

        public Integer visitUnaryOp(ExpressionParser.UnaryOpContext ctx) {
            TerminalNode op; // here to enforce type checking
            if ((op = ctx.MINUS()) != null) {
                return MINUS_OP;
            } else {
                throw new RuntimeException("Unrecognized unary operation: " + ctx.getText());
            }
        }

        public Integer visitFallThroughBaseExpr(ExpressionParser.FallThroughBaseExprContext ctx) {
            return visitBaseExpr(ctx.baseExpr());
        }

        public Integer visitBaseExpr(ExpressionParser.BaseExprContext ctx) {
            if (ctx instanceof ExpressionParser.ParenExprContext) {
                return visitParenExpr((ExpressionParser.ParenExprContext) ctx);
            } else if (ctx instanceof ExpressionParser.NumberContext) {
                return visitNumber((ExpressionParser.NumberContext) ctx);
            } else {
                throw new RuntimeException("Unrecognized baseExpr variant: " + ctx.getClass().getName());
            }
        }

        public Integer visitNumber(ExpressionParser.NumberContext ctx) {
            return parseInt(ctx.INT().getText());
        }

        private static final Map<Character, Integer> parseMap;
        static {
            parseMap = new HashMap<>();
            int value = 0;
            for (char c = '0'; c <= '9'; c++) {
                parseMap.put(c, value);
                value += 1;
            }
        }

        private int parseInt(String toParse) {
            try {
                int out = parseMap.get(toParse.charAt(0));
                for (int i = 1; i < toParse.length(); i++) {
                    out = (out * 10) + parseMap.get(toParse.charAt(i));
                }
                return out;
            } catch (NullPointerException npe) {
                throw new IllegalArgumentException(String.format("Could not parse string '%s' as int", toParse));
            }
        }
    } */
}
