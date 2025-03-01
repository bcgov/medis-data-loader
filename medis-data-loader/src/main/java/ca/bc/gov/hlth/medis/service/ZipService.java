package ca.bc.gov.hlth.medis.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ZipService {

	private static final Logger logger = LoggerFactory.getLogger(ZipService.class);

	private static final String GZIP_EXTENSION = ".gz";

	public File unzip(File file) throws IOException {
		// Create a new file without the .gz extension
		File tempFile = new File(StringUtils.substringBefore(file.getAbsolutePath(), GZIP_EXTENSION));

		try {
			FileInputStream fis = new FileInputStream(file);
			GZIPInputStream gis = new GZIPInputStream(fis);
			FileOutputStream fos = new FileOutputStream(tempFile);
			byte[] buffer = new byte[1024];
			int len;
			while ((len = gis.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}
			// close resources
			fos.close();
			gis.close();
		} catch (IOException e) {
			logger.error("Could not unzip file " + file.getName(), e);
		}

		return tempFile;

	}

}
