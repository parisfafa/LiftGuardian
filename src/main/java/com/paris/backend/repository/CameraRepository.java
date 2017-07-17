package com.paris.backend.repository;

import com.paris.backend.model.Camera;
import com.paris.backend.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by achen on 2017/7/15 0015.
 */
@Repository("cameraRepository")
public interface CameraRepository extends JpaRepository<Camera, Integer> {
    List<Camera> findCameraById(int id);
}
