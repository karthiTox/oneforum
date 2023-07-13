import { AuthContainer, LoginForm } from "src/features/auth";
import { NavBar } from "src/features/nav-bar";
import { SpacingBox } from "src/features/ui";

export function Login() {
  return (
    <>
      <NavBar currentPage="login" showNavigation={false}/>
      <SpacingBox />
      <AuthContainer>
        <LoginForm />
      </AuthContainer>
    </>
  );
}
