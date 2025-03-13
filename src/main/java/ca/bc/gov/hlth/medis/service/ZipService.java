package ca.bc.gov.hlth.medis.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ZipService {

	private static final Logger logger = LoggerFactory.getLogger(ZipService.class);

	private static final String GZIP_EXTENSION = ".gz";

	public File unzip(File zippedFile) throws IOException {
		if (zippedFile == null) {
			throw new IllegalArgumentException("No zippedFile provided");
		}
		// Create a new file without the .gz extension
		File unzippedFile = new File(StringUtils.substringBefore(zippedFile.getAbsolutePath(), GZIP_EXTENSION));

		FileInputStream fis = new FileInputStream(zippedFile);
		GZIPInputStream gis = new GZIPInputStream(fis);
		FileOutputStream fos = new FileOutputStream(unzippedFile);
		try (fis; gis; fos) {

			
			byte[] buffer = new byte[1024];
			int len;
			while ((len = gis.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}
		} catch (IOException e) {
			logger.error("Could not unzip file " + zippedFile.getName(), e);
		}
		finally {
			// Delete the zipped file as it's no longer required
			FileUtils.deleteQuietly(zippedFile);
		}

		return unzippedFile;

	}


}
