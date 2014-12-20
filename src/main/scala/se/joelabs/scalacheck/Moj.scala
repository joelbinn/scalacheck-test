package se.joelabs.scalacheck

trait Provider {
  def get: Int
}

case class Banan(a: Int, b: Provider) {
  val z = a + b.get
}

case class Bulle(b: String)

object Moj {
  def myMagicFunction(banan: Banan) = Bulle(banan.z + "")
}