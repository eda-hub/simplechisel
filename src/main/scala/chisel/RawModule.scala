package chisel

import ir.{IOPort, Module}

class RawModule {

  def  IO(d:String) : IOPort = {
    new IOPort(d)
  }

  def ser: String = Module(this).ser
}