package com.fitmanager.system.infra.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fitmanager.system.application.presentation.EmailDTO;
import com.fitmanager.system.application.presentation.PhoneDTO;
import com.fitmanager.system.application.presentation.StudentDTO;
import com.fitmanager.system.domain.Student.Student;
import com.fitmanager.system.domain.VO.Email;
import com.fitmanager.system.domain.VO.Phone;

@Configuration
public class MapperConfig {
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		TypeMap<Email, EmailDTO> emailTypeMap = modelMapper.createTypeMap(Email.class, EmailDTO.class);
		TypeMap<Phone, PhoneDTO> phoneTypeMap = modelMapper.createTypeMap(Phone.class, PhoneDTO.class);

		emailTypeMap.addMappings(mapper -> {
			mapper.map(src -> src.unwrap(), EmailDTO::setEmail);
		});

		phoneTypeMap.addMappings(mapper -> {
			mapper.map(src -> src.unwrap(), PhoneDTO::setPhone);
		});

		return modelMapper;
	}
}
