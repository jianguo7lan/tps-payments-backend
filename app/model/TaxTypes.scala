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

import controllers.ValueClassBinder._
import enumeratum._
import enumformat.EnumFormat
import play.api.libs.json.Format
import play.api.mvc.{PathBindable, QueryStringBindable}

import scala.collection.immutable

object TaxType {
  implicit val format: Format[TaxType] = EnumFormat(TaxTypes)
  implicit val pathBinder: QueryStringBindable[TaxType] = bindableA(_.toString)
  implicit val taxTypeBinder: PathBindable[TaxType] = valueClassBinder(_.toString)

}

sealed abstract class TaxType extends EnumEntry {
}

object TaxTypes extends Enum[TaxType] {

  def forCode(code: String): Option[TaxType] = values.find(_.toString == code)

  case object `self-assessment` extends TaxType {
  }

  case object vat extends TaxType {
  }

  case object epaye extends TaxType {
  }

  /**
   * Machine Game Duty
   */
  case object `mg-duty` extends TaxType {
  }

  /**
   * Merchandise in Baggage
   */

  case object mib extends TaxType {
  }

  /**
   * Other tax types
   */

  case object other extends TaxType {
  }

  /**
   * Stamp Duty Land Tax (Sdlt)
   */
  case object `stamp-duty` extends TaxType {
  }

  case object class2NationalInsurance extends TaxType {
  }

  /**
   * Customs or Custom Declarations Service
   */
  case object cds extends TaxType {
  }

  /**
   * Passengers
   */
  case object pngr extends TaxType {
  }

  case object `corporation-tax` extends TaxType {
  }

  final case object p800 extends TaxType {
  }

  /**
   * Northern Ireland
   */

  case object ni extends TaxType {
  }

  case object parcels extends TaxType {
  }

  /**
   * Insurance Premium Tax
   */

  case object insurancePremium extends TaxType {
  }

  /**
   * class3NationalInsurance
   */

  case object class3NationalInsurance extends TaxType {
  }

  case object `bioFuelsAndRoadGas` extends TaxType {
  }

  case object `airPassengerDuty` extends TaxType {
  }

  case object `beerDuty` extends TaxType {
  }

  case object `landfillTax` extends TaxType {
  }

  case object `aggregatesLevy` extends TaxType {
  }

  case object `climateChangeLevy` extends TaxType {
  }

  def values: immutable.IndexedSeq[TaxType] = findValues
}
