/*
 * Copyright 2020 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package model

import play.api.libs.json.{JsString, Json}
import support.{RichMatchers, UnitSpec}

class TaxTypesSpec extends UnitSpec {

  "de/serialize TaxTypes" in {

    val taxTypes = List(
      "self-assessment" -> TaxTypes.`self-assessment`,
      "vat" -> TaxTypes.vat,
      "epaye" -> TaxTypes.epaye,
      "mg-duty" -> TaxTypes.`mg-duty`,
      "mib" -> TaxTypes.mib,
      "other" -> TaxTypes.other,
      "stamp-duty" -> TaxTypes.`stamp-duty`,
      "class2NationalInsurance" -> TaxTypes.class2NationalInsurance,
      "class3NationalInsurance" -> TaxTypes.class3NationalInsurance,
      "cds" -> TaxTypes.cds,
      "pngr" -> TaxTypes.pngr,
      "corporation-tax" -> TaxTypes.`corporation-tax`,
      "p800" -> TaxTypes.p800,
      "ni" -> TaxTypes.ni,
      "parcels" -> TaxTypes.parcels,
      "insurancePremium" -> TaxTypes.insurancePremium,
      "bioFuelsAndRoadGas" -> TaxTypes.`bioFuelsAndRoadGas`,
      "airPassengerDuty" -> TaxTypes.`airPassengerDuty`,
      "beerDuty" -> TaxTypes.`beerDuty`,
      "landfillTax" -> TaxTypes.`landfillTax`,
      "aggregatesLevy" -> TaxTypes.aggregatesLevy,
      "climateChangeLevy" -> TaxTypes.`climateChangeLevy`
    )

    taxTypes.foreach { tt =>
      val jsValue = Json.toJson(tt._2)
      jsValue shouldBe JsString(tt._1) withClue s"serialize $tt"
      jsValue.as[TaxType] shouldBe tt._2 withClue s"deserialize $tt"
    }
  }
}

