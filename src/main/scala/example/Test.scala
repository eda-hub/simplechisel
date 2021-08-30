package example

import chisel.RawModule

class MyModule extends RawModule {
  val in = IO("Input")
  val out = IO("Output")
}

object Test extends App {
  println((new MyModule).ser)
}
