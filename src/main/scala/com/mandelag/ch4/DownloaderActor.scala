package com.mandelag.ch4

import akka.actor.Actor 

object DownloaderActor(url: String){
    def props = new Props(new DownloaderActor(url))
    case class Fetch
}
class DownloaderActor(url: String) extends Actor {
    import DownloaderActor._
    def receive =  {
        case _: => sender() ! url
    }
}