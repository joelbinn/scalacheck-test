package se.joelabs.scalacheck

import org.scalacheck.Arbitrary._
import org.scalacheck.{Arbitrary, Gen}
import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec
import org.scalatest.Matchers._
import org.scalatest.prop.PropertyChecks


class ConverterSpec extends FlatSpec with PropertyChecks with MockFactory {
  def createMojStub(id: java.lang.Long, z: String) = {
    val moj = stub[Moj]
    (moj.get _).when(id).returning(z)
    moj
  }

  val setupGen: Gen[(Pryl, Converter, String)] = for {
    id <- arbitrary[Long]
    age <- Gen.choose(0, 100)
    z <- Gen.alphaStr
  } yield (new Pryl(id, age), new Converter(createMojStub(id, z)), z)

  implicit lazy val arbSetup: Arbitrary[(Pryl, Converter, String)] = Arbitrary(setupGen)

  "A Converter" should "convert a Pryl to a Manik correctly" in {
    forAll { (setup: (Pryl, Converter, String)) =>
      val (pryl, converter, z) = setup
      val manik = converter.convert(pryl)

      manik.name should be === z + pryl.age
    }
  }
}