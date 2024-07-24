package org.example.dictionaryeejaxws.server.service.impl;

import org.example.dictionaryeejaxws.server.service.api.FileService;

import javax.ejb.Stateless;
import java.io.File;

@Stateless
public class FileServiceImpl implements FileService {

    @Override
    public File getFile(String fileName) {
        return new File(Thread.currentThread().getContextClassLoader().getResource(fileName).getFile());
    }
}
