package com.codahale.jerkson.tests

import com.codahale.jerkson.Json._
import java.io.ByteArrayInputStream
import org.scalatest.FlatSpec
import org.scalatest.Matchers

class StreamingSpec extends FlatSpec with Matchers {
  behavior of "Parsing a stream of objects"
  val json = """[
      {"id":1, "name": "Coda"},
      {"id":2, "name": "Niki"},
      {"id":3, "name": "Biscuit"},
      {"id":4, "name": "Louie"}
    ]"""

  it should "returns an iterator of stream elements" in {
    stream[CaseClass](new ByteArrayInputStream(json.getBytes)).toList shouldBe CaseClass(1, "Coda") :: CaseClass(2, "Niki") :: CaseClass(3, "Biscuit") :: CaseClass(4, "Louie") :: Nil
  }
}
