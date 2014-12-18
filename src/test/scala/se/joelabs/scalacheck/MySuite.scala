import org.junit.Test
import org.scalatest.junit.JUnitSuite
import org.scalatest.prop.Checkers
import org.scalacheck.Arbitrary._
import org.scalacheck.Prop._

class MySuite extends JUnitSuite with Checkers {
  @Test
  def testConcat() {
    check((a: List[Int], b: List[Int]) => a.size + b.size == (a ::: b).size)
  }

  @Test
  def testAdd() {
    check((a: Int, b: Int) => (a + b - b) == a)
  }
}