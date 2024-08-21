// Code generated by Wire protocol buffer compiler, do not edit.
// Source: Address in example.proto
@file:Suppress("DEPRECATION")

import com.squareup.wire.EnumAdapter
import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.ReverseProtoWriter
import com.squareup.wire.Syntax.PROTO_3
import com.squareup.wire.WireEnum
import com.squareup.wire.WireField
import com.squareup.wire.`internal`.JvmField
import com.squareup.wire.`internal`.JvmStatic
import com.squareup.wire.`internal`.sanitize
import kotlin.Any
import kotlin.AssertionError
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.Suppress
import okio.ByteString

public class Address(
    @field:WireField(
        tag = 1,
        adapter = "com.squareup.wire.ProtoAdapter#STRING",
        label = WireField.Label.OMIT_IDENTITY,
        schemaIndex = 0,
    )
    public val street: String = "",
    @field:WireField(
        tag = 2,
        adapter = "Address${'$'}City#ADAPTER",
        label = WireField.Label.OMIT_IDENTITY,
        schemaIndex = 1,
    )
    public val city: City = City.ROME,
    unknownFields: ByteString = ByteString.EMPTY,
) : Message<Address, Nothing>(ADAPTER, unknownFields) {
    @Deprecated(
        message = "Shouldn't be used in Kotlin",
        level = DeprecationLevel.HIDDEN,
    )
    override fun newBuilder(): Nothing = throw
    AssertionError("Builders are deprecated and only available in a javaInterop build; see https://square.github.io/wire/wire_compiler/#kotlin")

    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        if (other !is Address) return false
        if (unknownFields != other.unknownFields) return false
        if (street != other.street) return false
        if (city != other.city) return false
        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode
        if (result == 0) {
            result = unknownFields.hashCode()
            result = result * 37 + street.hashCode()
            result = result * 37 + city.hashCode()
            super.hashCode = result
        }
        return result
    }

    override fun toString(): String {
        val result = mutableListOf<String>()
        result += """street=${sanitize(street)}"""
        result += """city=$city"""
        return result.joinToString(prefix = "Address{", separator = ", ", postfix = "}")
    }

    public fun copy(
        street: String = this.street,
        city: City = this.city,
        unknownFields: ByteString = this.unknownFields,
    ): Address = Address(street, city, unknownFields)

    public companion object {
        @JvmField
        public val ADAPTER: ProtoAdapter<Address> = object : ProtoAdapter<Address>(
            FieldEncoding.LENGTH_DELIMITED,
            Address::class,
            "type.googleapis.com/Address",
            PROTO_3,
            null,
            "example.proto"
        ) {
            override fun encodedSize(`value`: Address): Int {
                var size = value.unknownFields.size
                if (value.street != "") {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(1, value.street)
                }
                if (value.city != Address.City.ROME) {
                    size += City.ADAPTER.encodedSizeWithTag(2, value.city)
                }
                return size
            }

            override fun encode(writer: ProtoWriter, `value`: Address) {
                if (value.street != "") {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.street)
                }
                if (value.city != Address.City.ROME) {
                    City.ADAPTER.encodeWithTag(writer, 2, value.city)
                }
                writer.writeBytes(value.unknownFields)
            }

            override fun encode(writer: ReverseProtoWriter, `value`: Address) {
                writer.writeBytes(value.unknownFields)
                if (value.city != Address.City.ROME) {
                    City.ADAPTER.encodeWithTag(writer, 2, value.city)
                }
                if (value.street != "") {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.street)
                }
            }

            override fun decode(reader: ProtoReader): Address {
                var street: String = ""
                var city: City = City.ROME
                val unknownFields = reader.forEachTag { tag ->
                    when (tag) {
                        1 -> street = ProtoAdapter.STRING.decode(reader)
                        2 -> try {
                            city = City.ADAPTER.decode(reader)
                        } catch (e: ProtoAdapter.EnumConstantNotFoundException) {
                            reader.addUnknownField(tag, FieldEncoding.VARINT, e.value.toLong())
                        }
                        else -> reader.readUnknownField(tag)
                    }
                }
                return Address(
                    street = street,
                    city = city,
                    unknownFields = unknownFields
                )
            }

            override fun redact(`value`: Address): Address = value.copy(
                unknownFields = ByteString.EMPTY
            )
        }

        private const val serialVersionUID: Long = 0L
    }

    public enum class City(
        override val `value`: Int,
    ) : WireEnum {
        ROME(0),
        BERLIN(1),
        LONDON(2),
        ;

        public companion object {
            @JvmField
            public val ADAPTER: ProtoAdapter<City> = object : EnumAdapter<City>(
                City::class,
                PROTO_3,
                City.ROME
            ) {
                override fun fromValue(`value`: Int): City? = City.fromValue(`value`)
            }

            @JvmStatic
            public fun fromValue(`value`: Int): City? = when (`value`) {
                0 -> ROME
                1 -> BERLIN
                2 -> LONDON
                else -> null
            }
        }
    }
}
