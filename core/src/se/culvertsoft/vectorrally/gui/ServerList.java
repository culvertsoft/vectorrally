package se.culvertsoft.vectorrally.gui;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import se.culvertsoft.vectorrally.model.network.ServerIpList;
import se.culvertsoft.vectorrally.network.Serializer;

public class ServerList {

	public static CompletableFuture<ServerIpList> getIpList() {
		return CompletableFuture.supplyAsync(new Supplier<ServerIpList>() {
			@Override
			public ServerIpList get() {
				try {
					DefaultHttpClient client = new DefaultHttpClient();
					HttpGet request = new HttpGet(
							"http://xn--smst-loa.se/vectorrally.php");

					HttpResponse response = client.execute(request);
					HttpEntity entity = response.getEntity();
					String content = EntityUtils.toString(entity);

					System.out.println(content);

					return Serializer.read(content, ServerIpList.class);
				} catch (IOException | HttpException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return new ServerIpList();
			}
		});
	}

}
