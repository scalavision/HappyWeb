package client

import org.scalajs.dom.document
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel, JSImport}
import scala.scalajs.js

@JSImport("styles.css", "Styles")
class Styles() extends js.Object

object Main {

  def main(args: Array[String]): Unit = {
    document.write("this is reloading ..???.. from scalajs crazy muock..")
    
    println("Hello World blaaahhh ...")
  }

}
