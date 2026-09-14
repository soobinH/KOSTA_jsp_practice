package service;

import java.io.OutputStream;

public interface CommonService {
	void imageView(String realPath,String filename, OutputStream out) throws Exception;
}
