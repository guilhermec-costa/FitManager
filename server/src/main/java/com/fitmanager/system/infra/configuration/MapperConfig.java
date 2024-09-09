package com.fitmanager.system.infra.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fitmanager.system.application.presentation.StudentDTO;
import com.fitmanager.system.domain.Student.Student;

@Configuration
public class MapperConfig {
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		TypeMap<Student, StudentDTO> studentTypeMap = modelMapper.createTypeMap(Student.class, StudentDTO.class);

		studentTypeMap.addMappings(mapper -> {
			mapper.map(src -> src.getEmail().unwrap(), StudentDTO::setEmail);
			mapper.map(src -> src.getPhone().unwrap(), StudentDTO::setPhone);
		});

		return modelMapper;
	}
}
