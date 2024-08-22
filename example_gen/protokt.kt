// Generated by protokt version 1.0.0-beta.2. Do not modify.
// Source: example.proto
@file:Suppress("DEPRECATION")

package protokt.v1

import protokt.v1.Collections.copyList
import protokt.v1.Collections.unmodifiableList
import protokt.v1.SizeCodecs.sizeOf
import protokt.v1.google.protobuf.Descriptor
import protokt.v1.google.protobuf.EnumDescriptor
import protokt.v1.google.protobuf.FileDescriptor
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmStatic

@GeneratedMessage(".Address")
public class Address private constructor(
  @GeneratedProperty(1)
  public val street: String,
  @GeneratedProperty(2)
  public val city: protokt.v1.Address.City,
  public val unknownFields: UnknownFieldSet = UnknownFieldSet.empty()
) : AbstractMessage() {
  private val `$messageSize`: Int by lazy {
    var result = 0
    if (street.isNotEmpty()) {
      result += sizeOf(10u) + sizeOf(street)
    }
    if (city.value != 0) {
      result += sizeOf(16u) + sizeOf(city)
    }
    result += unknownFields.size()
    result
  }

  override fun messageSize(): Int = `$messageSize`

  override fun serialize(writer: Writer) {
    if (street.isNotEmpty()) {
      writer.writeTag(10u).write(street)
    }
    if (city.value != 0) {
      writer.writeTag(16u).write(city)
    }
    writer.writeUnknown(unknownFields)
  }

  override fun equals(other: Any?): Boolean =
    other is Address &&
      other.street == street &&
      other.city == city &&
      other.unknownFields == unknownFields

  override fun hashCode(): Int {
    var result = unknownFields.hashCode()
    result = 31 * result + street.hashCode()
    result = 31 * result + city.hashCode()
    return result
  }

  override fun toString(): String =
    "Address(" +
      "street=$street, " +
      "city=$city" +
      if (unknownFields.isEmpty()) ")" else ", unknownFields=$unknownFields)"

  public fun copy(builder: Builder.() -> Unit): Address =
    Builder().apply {
      street = this@Address.street
      city = this@Address.city
      unknownFields = this@Address.unknownFields
      builder()
    }.build()

  @BuilderDsl
  public class Builder {
    public var street: String = ""

    public var city: protokt.v1.Address.City = protokt.v1.Address.City.from(0)

    public var unknownFields: UnknownFieldSet = UnknownFieldSet.empty()

    public fun build(): Address =
      Address(
        street,
        city,
        unknownFields
      )
  }

  public companion object Deserializer : AbstractDeserializer<Address>() {
    @JvmStatic
    override fun deserialize(reader: Reader): Address {
      var street = ""
      var city = protokt.v1.Address.City.from(0)
      var unknownFields: UnknownFieldSet.Builder? = null

      while (true) {
        when (reader.readTag()) {
          0u -> return Address(
            street,
            city,
            UnknownFieldSet.from(unknownFields)
          )
          10u -> street = reader.readString()
          16u -> city = reader.readEnum(protokt.v1.Address.City)
          else ->
            unknownFields =
              (unknownFields ?: UnknownFieldSet.Builder()).also {
                it.add(reader.readUnknown())
              }
        }
      }
    }

    @JvmStatic
    public operator fun invoke(dsl: Builder.() -> Unit): Address = Builder().apply(dsl).build()
  }

  public sealed class City(
    override val `value`: Int,
    override val name: String
  ) : Enum() {
    public object ROME : City(0, "ROME")

    public object BERLIN : City(1, "BERLIN")

    public object LONDON : City(2, "LONDON")

    public class UNRECOGNIZED(
      `value`: Int
    ) : City(value, "UNRECOGNIZED")

    public companion object Deserializer : EnumReader<City> {
      override fun from(`value`: Int): City =
        when (value) {
          0 -> ROME
          1 -> BERLIN
          2 -> LONDON
          else -> UNRECOGNIZED(value)
        }
    }
  }
}

@GeneratedMessage(".User")
public class User private constructor(
  @GeneratedProperty(1)
  public val id: Long,
  @GeneratedProperty(2)
  public val name: String,
  @GeneratedProperty(3)
  public val married: Boolean,
  @GeneratedProperty(4)
  public val friends: List<protokt.v1.User>,
  @GeneratedProperty(5)
  public val spouse: protokt.v1.User?,
  @GeneratedProperty(6)
  public val address: protokt.v1.Address?,
  public val contact: Contact?,
  public val unknownFields: UnknownFieldSet = UnknownFieldSet.empty()
) : AbstractMessage() {
  private val `$messageSize`: Int by lazy {
    var result = 0
    if (id != 0L) {
      result += sizeOf(8u) + sizeOf(id)
    }
    if (name.isNotEmpty()) {
      result += sizeOf(18u) + sizeOf(name)
    }
    if (married) {
      result += sizeOf(24u) + 1
    }
    if (friends.isNotEmpty()) {
      result += (sizeOf(34u) * friends.size) + friends.sumOf { sizeOf(it) }
    }
    if (spouse != null) {
      result += sizeOf(42u) + sizeOf(spouse)
    }
    if (address != null) {
      result += sizeOf(50u) + sizeOf(address)
    }
    when (contact) {
      is Contact.Email ->
        result += sizeOf(58u) + sizeOf(contact.email)
      is Contact.Phone ->
        result += sizeOf(66u) + sizeOf(contact.phone)
      null -> Unit
    }
    result += unknownFields.size()
    result
  }

  override fun messageSize(): Int = `$messageSize`

  override fun serialize(writer: Writer) {
    if (id != 0L) {
      writer.writeTag(8u).write(id)
    }
    if (name.isNotEmpty()) {
      writer.writeTag(18u).write(name)
    }
    if (married) {
      writer.writeTag(24u).write(married)
    }
    friends.forEach { writer.writeTag(34u).write(it) }
    if (spouse != null) {
      writer.writeTag(42u).write(spouse)
    }
    if (address != null) {
      writer.writeTag(50u).write(address)
    }
    when (contact) {
      is Contact.Email ->
        writer.writeTag(58u).write(contact.email)
      is Contact.Phone ->
        writer.writeTag(66u).write(contact.phone)
      null -> Unit
    }
    writer.writeUnknown(unknownFields)
  }

  override fun equals(other: Any?): Boolean =
    other is User &&
      other.id == id &&
      other.name == name &&
      other.married == married &&
      other.friends == friends &&
      other.spouse == spouse &&
      other.address == address &&
      other.contact == contact &&
      other.unknownFields == unknownFields

  override fun hashCode(): Int {
    var result = unknownFields.hashCode()
    result = 31 * result + id.hashCode()
    result = 31 * result + name.hashCode()
    result = 31 * result + married.hashCode()
    result = 31 * result + friends.hashCode()
    result = 31 * result + spouse.hashCode()
    result = 31 * result + address.hashCode()
    result = 31 * result + contact.hashCode()
    return result
  }

  override fun toString(): String =
    "User(" +
      "id=$id, " +
      "name=$name, " +
      "married=$married, " +
      "friends=$friends, " +
      "spouse=$spouse, " +
      "address=$address, " +
      "contact=$contact" +
      if (unknownFields.isEmpty()) ")" else ", unknownFields=$unknownFields)"

  public fun copy(builder: Builder.() -> Unit): User =
    Builder().apply {
      id = this@User.id
      name = this@User.name
      married = this@User.married
      friends = this@User.friends
      spouse = this@User.spouse
      address = this@User.address
      contact = this@User.contact
      unknownFields = this@User.unknownFields
      builder()
    }.build()

  public sealed class Contact {
    public data class Email(
      @GeneratedProperty(7)
      public val email: String
    ) : Contact()

    public data class Phone(
      @GeneratedProperty(8)
      public val phone: String
    ) : Contact()
  }

  @BuilderDsl
  public class Builder {
    public var id: Long = 0L

    public var name: String = ""

    public var married: Boolean = false

    public var friends: List<protokt.v1.User> = emptyList()
      set(newValue) {
        field = copyList(newValue)
      }

    public var spouse: protokt.v1.User? = null

    public var address: protokt.v1.Address? = null

    public var contact: Contact? = null

    public var unknownFields: UnknownFieldSet = UnknownFieldSet.empty()

    public fun build(): User =
      User(
        id,
        name,
        married,
        unmodifiableList(friends),
        spouse,
        address,
        contact,
        unknownFields
      )
  }

  public companion object Deserializer : AbstractDeserializer<User>() {
    @JvmStatic
    override fun deserialize(reader: Reader): User {
      var id = 0L
      var name = ""
      var married = false
      var friends: MutableList<protokt.v1.User>? = null
      var spouse: protokt.v1.User? = null
      var address: protokt.v1.Address? = null
      var contact: Contact? = null
      var unknownFields: UnknownFieldSet.Builder? = null

      while (true) {
        when (reader.readTag()) {
          0u -> return User(
            id,
            name,
            married,
            unmodifiableList(friends),
            spouse,
            address,
            contact,
            UnknownFieldSet.from(unknownFields)
          )
          8u -> id = reader.readInt64()
          18u -> name = reader.readString()
          24u -> married = reader.readBool()
          34u ->
            friends =
              (friends ?: mutableListOf()).apply {
                reader.readRepeated(false) {
                  add(reader.readMessage(protokt.v1.User))
                }
              }
          42u -> spouse = reader.readMessage(protokt.v1.User)
          50u -> address = reader.readMessage(protokt.v1.Address)
          58u -> contact = Contact.Email(reader.readString())
          66u -> contact = Contact.Phone(reader.readString())
          else ->
            unknownFields =
              (unknownFields ?: UnknownFieldSet.Builder()).also {
                it.add(reader.readUnknown())
              }
        }
      }
    }

    @JvmStatic
    public operator fun invoke(dsl: Builder.() -> Unit): User = Builder().apply(dsl).build()
  }
}

@GeneratedFileDescriptor
public object example_file_descriptor {
  public val descriptor: FileDescriptor by lazy {
    val descriptorData =
      arrayOf(
        "\n\rexample.proto\"`\nAddress\nstreet " +
          "(\t\ncity (2\r.Address.City\"(\nCity" +
          "\b\nROME \n\nBERLIN\n\nLONDON\"ﾸ\nUs" +
          "er\n\nid (\nname (\t\nmarried" +
          " (\b\nfriends (2.User\nspouse" +
          " (2.UserHﾈ\naddress (2\b.Add" +
          "ress\nemail (\tH \nphone\b (\tH B\t" +
          "\ncontactB\t\n_spousebproto3"
      )

    FileDescriptor.buildFrom(
      descriptorData,
      listOf()
    )
  }
}

public val Address.City.Deserializer.descriptor: EnumDescriptor
  get() = Address.descriptor.enumTypes[0]

public val Address.Deserializer.descriptor: Descriptor
  get() = example_file_descriptor.descriptor.messageTypes[0]

public val User.Deserializer.descriptor: Descriptor
  get() = example_file_descriptor.descriptor.messageTypes[1]
