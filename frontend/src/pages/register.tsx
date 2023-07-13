import { AuthContainer, RegisterForm } from "src/features/auth";
import { NavBar } from "src/features/nav-bar";
import { SpacingBox } from "src/features/ui";

export function Register() {
  return (
    <>
      <NavBar currentPage="register" showNavigation={false}/>
      <SpacingBox />
      <AuthContainer>
        <RegisterForm />
      </AuthContainer>
    </>
  );
}
