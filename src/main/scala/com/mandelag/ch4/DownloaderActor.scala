package com.mandelag.ch4

import akka.actor._
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import scala.concurrent.Future
import scala.util.{Failure, Success}

object DownloaderActor {
    def props(url: String) = Props(new DownloaderActor(url))
    case class Fetch()
    case class GetData()
    case class DownloadedData(str: String)
}

class DownloaderActor(url: String) extends Actor {
    import DownloaderActor._
    import akka.pattern.pipe
    import context.dispatcher
    
    val http = Http(context.system)

    def receive =  {
        case Fetch() => sender() ! url
        case GetData() => {
            http.singleRequest(HttpRequest(uri=url)).pipeTo(self)
            sender() ! ""
        }
        case HttpResponse(StatusCodes.OK, headers, entity, _) => {
            sender() ! headers
        }
    }
}