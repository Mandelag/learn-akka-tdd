/** Workbook to learn about future, for both Scala and Akka
  *
  */

val runtime = Runtime.getRuntime()

println(
  """
    |Getting to know the java.lang.Runtime object!
    |(where have I gone after all this time :"(.. )
  """.stripMargin)

println(s"""
  |My processors has ${runtime.availableProcessors()} processors available.
  |It have ${runtime.freeMemory()/1000000} MB out of ${runtime.totalMemory()/1000000} MB total in JVM memory.
  |The JVM wouldn't allocate any further than ${runtime.maxMemory()/1000000} MB though..
""".stripMargin)

println(
  s"""
     |I could exec() another process and then getting the process I/O/E stream.
     |I could destroy() the process or halt the current thread to waitFor() the process to stop.
     |I could get their exitValue() codes.
     |
     |After I have my fun with the process..
     |
     |I could addShutdownHook(Thread hook) to prepare for shutdown.
     |I could exit(int code) to initiate shutdown sequence for the JVM.
     |I could even run the garbage collection gc process.
     |I could halt(int code) to *forcibly* terminate the JVM.
     |I could load(String library) as dynamic library.
     |I could loadLibrary(String libname) as dynamic library for specific name.
     |I could removeShutdownHook(Thread hook)
     |I could runFinalization()
     |I could traceInstruction(boolean on)
     |I could traceMethodCall(boolean on)
     |
   """.stripMargin)
