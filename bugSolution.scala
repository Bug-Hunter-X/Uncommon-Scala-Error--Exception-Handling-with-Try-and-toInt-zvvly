```scala
import scala.util.{Try, Success, Failure}

case class User(id: Int, name: String)

object Main extends App {
  val users = List(User(1, "John"), User(2, "Jane"))

  val result = users.map(user => {
    Try(user.name.toInt) match {
        case Success(i) => i
        case Failure(_) => 0 // Or handle it more meaningfully (e.g. log error)
      }
  })

  println(result)
}
```