package se.nording.bootsbootique;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BootRepository extends JpaRepository<Boot, Integer> {
    List<Boot> findBootBySizeAndType(Float size, BootType type);

    List<Boot> findBootBySize(Float size);
}

