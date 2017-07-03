import java.io.{File, PrintWriter}

import scala.io.Source

/**
 * Created by neerbans on 9/21/2015.
 */
object Arrange {
  def main(args: Array[String]): Unit = {

    val path2 = "C:\\files\\test2.txt"
    val path = "C:\\files\\words.txt"

    //val z = arrange(path2)
    //arrangeFile(path, z)
    arrangeFile(path)
  }

//  def arrange(path: String): List[String] = {
//    var z: List[String] = List()
//    val bufferedSource = Source.fromFile(path)
//    for (line <- bufferedSource.getLines()) {
//      z = line :: z
//    }
//    bufferedSource.close()
//
//    return z.sorted
//  }

  def arrangeFile(path: String) {

    println(path)
    var z: List[String] = List()
    val bufferedSource = Source.fromFile(path, "iso-8859-1")
    for (line <- bufferedSource.getLines()) {
      z = line :: z
    }
    bufferedSource.close()

    z = z.sorted
    for (x <- z)
      println(x)

    val writer: PrintWriter = new PrintWriter(path)
    writer.close()

    val writer2: PrintWriter = new PrintWriter(path)
    for (x <- z) {
      writer2.write(x)
      writer2.write("\r\n")
    }
    writer2.close()
  }

}
