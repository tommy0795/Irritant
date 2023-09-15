package org.edf.cat.mmesi.Irritant.service;

import org.edf.cat.mmesi.Irritant.model.File;


import java.util.List;
import java.util.UUID;

/**
 * @author TBF053DN
 */
public interface FileService {

    List<?> findAll();

    File update(UUID id, File file);

    File save(File file);

    void delete(UUID id);
}
