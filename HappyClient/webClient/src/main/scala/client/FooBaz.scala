package client

import org.scalajs.dom.document
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}
import scala.scalajs.js

@JSExportTopLevel("Babar")
class Foobaz(x: String) {
  def method(y: String): Int = x.length + y.length
}
