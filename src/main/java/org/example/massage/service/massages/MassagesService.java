package org.example.massage.service.massages;

import lombok.RequiredArgsConstructor;
import org.example.massage.domain.Massages;
import org.example.massage.repository.MassagesRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MassagesService {

	private final MassagesRepository repository;

	public Massages getMassage(Long id) {
		return repository.findById(id).orElseThrow(NullPointerException::new);
	}
}
