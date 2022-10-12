package rs.dxt.breakout

import com.badlogic.gdx.backends.lwjgl3.{Lwjgl3Application, Lwjgl3ApplicationConfiguration}

object Main extends App {
  val config = new Lwjgl3ApplicationConfiguration
  config.setTitle("Breakout")
  config.setWindowSizeLimits(800, 600, 800, 600)
  new Lwjgl3Application(new Engine, config)
}
