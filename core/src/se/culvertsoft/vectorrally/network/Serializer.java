package se.culvertsoft.vectorrally.network;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import se.culvertsoft.mgen.javapack.classes.MGenBase;
import se.culvertsoft.mgen.javapack.serialization.BinaryReader;
import se.culvertsoft.mgen.javapack.serialization.BinaryWriter;
import se.culvertsoft.mgen.javapack.serialization.JsonReader;
import se.culvertsoft.mgen.javapack.serialization.JsonWriter;
import se.culvertsoft.vectorrally.model.ClassRegistry;

public final class Serializer {
	private Serializer() {
	}

	static final ClassRegistry classRegistry;
	static final ByteArrayOutputStream writeBuffer;
	static final JsonWriter jsonWriter;
	static final BinaryWriter binaryWriter;
	static final JsonReader jsonReader;;
	static final BinaryReader binaryReader;;

	static {
		classRegistry = new ClassRegistry();
		writeBuffer = new ByteArrayOutputStream();
		jsonWriter = new JsonWriter(writeBuffer, classRegistry);
		binaryWriter = new BinaryWriter(writeBuffer, classRegistry);
		jsonReader = new JsonReader(classRegistry);
		binaryReader = new BinaryReader(new ByteArrayInputStream(new byte[0]),
				classRegistry);
	}

	public static synchronized MGenBase read(String msg) throws IOException {
		return jsonReader.readObject(msg);
	}

	public static synchronized <T extends MGenBase> T read(String msg,
			Class<T> cls) throws IOException {
		return jsonReader.readObject(msg, cls);
	}

	public static synchronized MGenBase read(byte[] msg) throws IOException {
		return binaryReader.setInput(new ByteArrayInputStream(msg))
				.readObject();
	}

	public static synchronized <T extends MGenBase> T read(byte[] msg,
			Class<T> cls) throws IOException {
		return binaryReader.setInput(new ByteArrayInputStream(msg)).readObject(
				cls);
	}

	public static synchronized String wrtJson(MGenBase msg) throws IOException {
		return jsonWriter.writeObjectToString(msg);
	}

	public static synchronized byte[] wrtBin(MGenBase msg) throws IOException {
		binaryWriter.writeObject(msg);
		byte[] out = writeBuffer.toByteArray();
		writeBuffer.reset();
		return out;
	}

}
