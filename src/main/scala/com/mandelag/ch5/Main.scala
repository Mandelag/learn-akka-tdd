object PavingMyFutures {

  def main(args: Array[String]): Unit = {
    import scala.concurrent.{Await, Future, TimeoutException}
    import scala.util.{Failure, Success}
    import scala.concurrent.ExecutionContext.Implicits.global
    import scala.concurrent.duration._

    val future: Future[String] = Future[String] {
      Thread.sleep(4000)
      //println("yeu")
      //throw(new TimeoutException("Noooo"))
      "successful"
    }

    future foreach(result => {
      println(s"You're a ${result} person.")
    })

    future onComplete {
      case Success(values) => for (value <- values) println(value)
      case Failure(t) => println(s"Learn something new ${t.getMessage()}")
    }

    Thread.sleep(5000)
    // println(Await.result(future, 5 seconds))
    // https://stackoverflow.com/questions/31738240/why-is-this-future-not-executed/31738367 --> because the program already closed!
    // It needs thread sleep, or use Await.result
    // https://docs.scala-lang.org/overviews/core/futures.html#callbacks
  }

}