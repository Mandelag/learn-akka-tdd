package com.mandelag.ch4

import akka.actor._

object DownloaderActor {
    def props(url: String) = Props(new DownloaderActor(url))
    case class Fetch()
    case class GetData()
    case class DownloadedData(str: String)
}
class DownloaderActor(url: String) extends Actor {
    import DownloaderActor._
    def receive =  {
        case Fetch() => sender() ! url
        case GetData() => sender() ! getData
    }

    private def getData = ???
}