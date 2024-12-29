```scala
import scala.util.Try

case class User(id: Int, name: String)

object Main extends App {
  val users = List(User(1, "John"), User(2, "Jane"))

  //Error-prone code
  val result = users.map(user => {
    Try(user.name.toInt).toOption.getOrElse(0) //This can throw NumberFormatException if name is not a number
  })

  println(result)
}
```