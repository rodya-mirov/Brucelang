# This is the hand-written AST package

This should be distinguished from the ANTLR-generated parse tree. That tree is great and
all, but we actually want to turn the tree into something we can execute, and not deal
with the cruft that comes from parsing.

So we'll be transforming the parse tree into an AST, still with visitors and so on.
