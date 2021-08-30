package chisel.ir
import scala.reflect.ClassTag
import scala.reflect.runtime.universe._

case class Module(val p: Any) {
  def ser: String = {
    var s = "Module: \n"
     classAccessors[example.MyModule].foreach(t =>
       s += " " + t.name.toString.trim + ":" + getValue[example.MyModule](p.asInstanceOf[example.MyModule],t.name).asInstanceOf[chisel.ir.IOPort].ser + "\n"
    )
    s
  }
  def classAccessors[T: TypeTag]: List[TermSymbol] = typeOf[T].members.collect {
    case m: TermSymbol if m.isVal => m
  }.toList

  def getValue[T: TypeTag : ClassTag](obj: T, memberName:  Name): Any = {
    val symbol = typeOf[T].member(memberName).asTerm

    val m = runtimeMirror(obj.getClass.getClassLoader)
    val im = m.reflect(obj)

    im.reflectField(symbol).get
//    im.reflectMethod(symbol).apply()
  }
}
