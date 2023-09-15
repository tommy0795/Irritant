package org.edf.cat.mmesi.Irritant.service.impl;

import org.edf.cat.mmesi.Irritant.model.File;
import org.edf.cat.mmesi.Irritant.service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author TBF053DN
 */

@Service
public class FileServiceImpl implements FileService {

    @Override
    public List<?> findAll() {
        return null;
    }

    @Override
    public File update(UUID id, File file) {
        return null;
    }

    @Override
    public File save(File file) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
