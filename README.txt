
 This "simple as possible" package employs reflection on java.awt.Graphics
 and java.awt.Graphics2D to generate a stub class source code that can be
 instrumented arbitrarily.

 The stub class requires a Graphics2D instance in its constructor, which
 gets called from each method on the stub.  In this way, the debug or trace
 class is injected into the graphics call graph by the user.

