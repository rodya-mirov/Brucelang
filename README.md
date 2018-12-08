# Brucelang

Docs TBD because they actually take a long time

You can run this, sort of, by running the `Main` class with arg `whatever.bl` where that's
your source file. It'll do something, if you have it configured right.

Probably best to get a real working `mvn` command that runs this at some point but IntelliJ will
just intuit everything for now.

#### UPDATE: December 2018

This project is effectively dead for now. To be honest I ran out of spare time, but with that hiatus, I had time to rethink a lot of things. I think I made some wrong design choices as I went, both in design of the language and in design of the implementation. I hope to restart this project some time next year, but it will be a total rewrite (probably in Rust), and a somewhat different language (with type parameters baked into the language much earlier), with the same design principles (non-Turing-completeness, provable complexity bounds baked in, and easy additions of "library code" to allow it to be a "safe scripting language" to expose to a user, and run on managed hardware).
