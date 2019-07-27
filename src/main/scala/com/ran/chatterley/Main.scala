package com.ran.chatterley

import com.ran.chatterley.config.DbConfiguration
import com.ran.chatterley.entity.User
import com.typesafe.config.ConfigFactory

object Main extends App with DbConfiguration {
  println("Chatterley started")
  println(ConfigFactory.load().getString("db.db.url"))
  println(config.config)
  val user = User(Some(1), "me", "43224")

}
