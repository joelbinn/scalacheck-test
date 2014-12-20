import org.scalacheck.Arbitrary._
import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec
import org.scalatest.Matchers._
import org.scalatest.prop.PropertyChecks
import se.joelabs.scalacheck.Moj.myMagicFunction
import se.joelabs.scalacheck.{Banan, Bulle, Provider}

class MojSpec extends FlatSpec with PropertyChecks with MockFactory {
  it should "be converted correctly" in {
    forAll { (n: Int, z: Int) =>
      val p = stub[Provider]
      (p.get _).when().returns(z)
      val res = myMagicFunction(Banan(n, p))
      res should be === Bulle(n + z + "")
    }
  }
}