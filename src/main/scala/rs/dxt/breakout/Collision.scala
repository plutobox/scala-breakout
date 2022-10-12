package rs.dxt.breakout

trait Collision {
  def x: Int

  def y: Int

  def w: Int

  def h: Int

  def collidesWith(ball: Ball): Boolean = {
    y + h > ball.y + ball.ySpeed - ball.size && y < ball.y + ball.ySpeed + ball.size &&
      x + w > ball.x + ball.xSpeed - ball.size && x < ball.x + ball.xSpeed + ball.size
  }
}
