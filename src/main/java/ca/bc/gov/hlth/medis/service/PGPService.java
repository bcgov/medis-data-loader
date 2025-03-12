package ca.bc.gov.hlth.medis.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.pgpainless.sop.SOPImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import sop.DecryptionResult;
import sop.ReadyWithResult;
import sop.SOP;

@Service
public class PGPService {
	private static final Logger logger = LoggerFactory.getLogger(PGPService.class);
	
	private static final String SEPARATOR = ".";
	
	@Value("${pgp.key.file:0}")
	private String keyFile;
	
	@Value("${sftp.local-directory}")
	private String localDirectory;
	
	public File decrypt(File encryptedFile) {
		SOP sop = new SOPImpl();
		// decrypt a message and verify its signature(s)
		File secretKeyFile = new File(keyFile);
		try (FileInputStream keyIS = new FileInputStream(secretKeyFile); FileInputStream fileIS =  new FileInputStream(encryptedFile)) {
			byte[] secretKey = keyIS.readAllBytes();

			byte[] ciphertext = fileIS.readAllBytes();

			ReadyWithResult<DecryptionResult> readyWithResult = sop.decrypt()
			        .withKey(secretKey)
			        .ciphertext(ciphertext);

		    File decryptedFile = generateTempFile(encryptedFile);
			readyWithResult.writeTo(new FileOutputStream(decryptedFile));
			return decryptedFile;
		} catch (IOException e) {
			logger.error("Could not decrypt file {}. {}", encryptedFile.getName(), e.getMessage());
			return null;
		}
	}
	
	private File generateTempFile(File encryptedFile) throws IllegalArgumentException, IOException {
		// This will strip the .gpg extension from foo.txt.zip.gpg leaving foo.txt.zip
		String decryptedFileName = FilenameUtils.getBaseName(encryptedFile.getName());

		// Get the file name with no extension (e.g. foo from foo.zip.gpg)
		String prefix = StringUtils.substringBefore(FilenameUtils.getBaseName(decryptedFileName), SEPARATOR);

		// Get the double extension (.zip.gpg)
		String extension = StringUtils.substringAfter(decryptedFileName, SEPARATOR);
		
		File tempFile = Files.createTempFile(Paths.get(localDirectory), prefix, SEPARATOR + extension).toFile();
		tempFile.deleteOnExit();
		
		return tempFile;
	}
	
}
