
 This "simple as possible" package employs reflection to generate a
 stub class source code that can be instrumented arbitrarily.

 The stub class requires an instance of the objective class in its
 constructor, which gets called from each method on the stub.  In this
 way, the debug or trace class is injected into the call graph by the
 user.

 The default / built-in example generates DebugGraphics2D stub for the
 java.awt.Graphics2D objective.

