package a_feb_27;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class H_Member {
	private String username;
	@Setter
	private String password;
	private String irum;
	private String email;
	private LocalDate birthday;
}