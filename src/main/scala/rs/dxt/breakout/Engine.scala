package rs.dxt.breakout

import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.{Game, Gdx}
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.ParticleEffect

class Engine extends Game {

  val rad = 20
  lazy val shape: ShapeRenderer = new ShapeRenderer
  lazy val ball: Ball = new Ball(Gdx.graphics.getWidth / 2, Gdx.graphics.getHeight / 2, rad, 3, 3)
  val paddle: Paddle = new Paddle

  var blocks: Seq[Block] = Seq[Block]()
  val colors: Seq[Color] = Seq[Color](Color.YELLOW, Color.GREEN, Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE)
  val effect: ParticleEffect = new ParticleEffect()

  override def create(): Unit = {
    val blockWidth = 63
    val blockHeight = 20
    (Gdx.graphics.getWidth / 2 to Gdx.graphics.getHeight by blockHeight + 10).zipWithIndex.foreach({case (y: Int, colorIndex: Int) =>
      (0 to Gdx.graphics.getWidth by blockWidth + 10).foreach(x => {
        blocks = blocks :+ Block(x, y, blockWidth, blockHeight, colors(colorIndex))
      })
    })
  }

  def update(): Unit = {
    paddle.checkCollision(ball)
    blocks.foreach(_.checkCollision(ball))
    paddle.update()
    ball.update()
  }

  override def render(): Unit = {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    shape.begin(ShapeRenderer.ShapeType.Filled)

    update()

    blocks.foreach(_.draw(shape))
    paddle.draw(shape)
    ball.draw(shape)
//    effect.draw()

    shape.end()
  }
}
