import org.scalacheck.Arbitrary._
import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec
import org.scalatest.Matchers._
import org.scalatest.prop.PropertyChecks

import scala.collection.mutable.Stack


class StackSpec extends FlatSpec with PropertyChecks with MockFactory {

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    assert(stack.pop() === 2)
    assert(stack.pop() === 1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new Stack[String]
    intercept[NoSuchElementException] {
      emptyStack.pop()
    }
  }

  def myMagicFunction(banan: Banan) = Bulle(banan.z + "")

  trait Provider {
    def get: Int
  }

  case class Banan(a: Int, b: Provider) {
    val z = a + b.get
  }

  case class Bulle(b: String)

  it should "be converted correctly" in {
    forAll { (n: Int, z: Int) =>
      val p = mock[Provider]
      (p.get _).expects().returning(z)
      val res = myMagicFunction(Banan(n, p))
      res should be === Bulle(n + z + "")
    }
  }

}