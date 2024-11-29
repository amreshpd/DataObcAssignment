package com.nt.config;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.nt.listener.JobMonitoringListener;
import com.nt.model.Employee;
import com.nt.repository.IEmployeeRepository;

@Configuration
@EnableBatchProcessing
public class Config {

	@Autowired
	private JobMonitoringListener listner;
	@Autowired
	private ItemProcessor<? super List<Employee>, ? extends Employee> processor;
	@Autowired
	private IEmployeeRepository repo;

	@Bean
	public FlatFileItemReader<Employee> createReader() {
		return new FlatFileItemReaderBuilder<Employee>().name("file_reader")
				.resource(new FileSystemResource("EmployeeInfo.csv"))
				.delimited()
				.names("empId", "empFName", "empLName", "designation", "event", "eventDate", "notes")
				.targetType(Employee.class)
				.build();
	}

	@Bean(name = "writer")
	public RepositoryItemWriter<Employee> createWriter() {
		return new RepositoryItemWriterBuilder<Employee>()
				.repository(repo)
				.methodName("save")
				.build();
	}

	@SuppressWarnings("unchecked")
	@Bean(name="step1")
	public Step createStep1(JobRepository repository, PlatformTransactionManager txMgmr) {
		return new StepBuilder("step1", repository)
				.<List<Employee>, Employee>chunk(3, txMgmr)
				.reader((ItemReader<? extends List<Employee>>) createReader())
				.processor(processor)
				.writer(createWriter())
				.build();
	}
	
	@Bean(name="job1")
	public Job createJobObject(JobRepository repository,Step step1) {
		return new JobBuilder("job1",repository)
				.incrementer(new RunIdIncrementer())
				.listener(listner)
				.start(step1)
				.build();
	}
}