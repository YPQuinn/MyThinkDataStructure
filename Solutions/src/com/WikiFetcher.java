package com;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Instant;


public class WikiFetcher {
	private long lastRequestTime = -1;
	private long minInterval = 3000;

	/**
	 * Fetches and parses a URL string, returning a list of paragraph elements.
	 *
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public Elements fetchWikipedia(String url) throws IOException {
		sleepIfNeeded();

		// download and parse the document
		Connection conn = Jsoup.connect(url);
		Document doc = conn.get();

		// select the content text and pull out the paragraphs.
		Element content = doc.getElementById("mw-content-text");
		
		// TODO: avoid selecting paragraphs from sidebars and boxouts
		Elements paras = content.select("p");
		return paras;
	}

	/**
	 * Reads the contents of a Wikipedia page from src/resources.
	 *
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public Elements readWikipedia(String url) throws IOException {
		URL realURL = new URL(url);

		// assemble the file name
		String slash = File.separator;
		String filename = "resources" + slash + realURL.getHost() + realURL.getPath();

		// read the file
		InputStream stream = WikiFetcher.class.getClassLoader().getResourceAsStream(filename);
		Document doc = Jsoup.parse(stream, "UTF-8", filename);

		// parse the contents of the file
		// TODO: factor out the following repeated code
		Element content = doc.getElementById("mw-content-text");
		Elements paras = content.select("p");
		return paras;
	}

	/**
	 * Rate limits by waiting at least the minimum interval between requests.
	 */
	private void sleepIfNeeded() {
		if (lastRequestTime != -1) {
			long currentTime = System.currentTimeMillis();
			long nextRequestTime = lastRequestTime + minInterval;
			if (currentTime < nextRequestTime) {
				try {
					Instant instant = Instant.ofEpochMilli(nextRequestTime);
					System.out.println("Sleeping until " + instant.toString());
					Thread.sleep(nextRequestTime - currentTime);
				} catch (InterruptedException e) {
					System.err.println("Warning: sleep interrupted in fetchWikipedia.");
				}
			}
		}
		lastRequestTime = System.currentTimeMillis();
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		WikiFetcher wf = new WikiFetcher();
		String url = "https://en.wanweibaike.com/wiki-Java_(programming_language)";
		Elements paragraphs = wf.readWikipedia(url);

		for (Element paragraph: paragraphs) {
			System.out.println(paragraph);
		}
	}
}