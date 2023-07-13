import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { AuthData } from "src/features/data";
import { useAxios } from "src/features/lib/use-axios";
import { useAuth } from "src/features/auth";

export function LoginForm() {
  const navigate = useNavigate();
  const axios = useAxios();
  const auth = useAuth();

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const onLogin = async () => {
    setError("");
    if (password.length < 6) {
      setError("password length shold be atleast 6 ");
      return;
    }

    axios
      .post("/auth/login", {
        email,
        password,
      })
      .then((response) => {
        auth.login(response.data as AuthData);
        navigate("/");
      })
      .catch((error) => {
        setError(error.response.data.message);
      });
  };

  return (
    <form
      onSubmit={(e) => {
        e.preventDefault();
        onLogin();
      }}
      className="text-center w-100"
      style={{
        maxWidth: "430px",
      }}
    >
      <h1 className="fs-3 mb-1 fw-bold">Welcome back!</h1>
      <p className="fs-6 mb-5">
        Enter your email address to login to your account.
      </p>

      <div className="mb-3 text-start">
        <label htmlFor="email" className="form-label">
          Email address
        </label>
        <input
          type="email"
          className="form-control rounded"
          id="email"
          placeholder="xyz@email.com"
          onChange={(e) => setEmail(e.target.value)}
        />
      </div>

      <div className="mb-5 text-start">
        <label htmlFor="password" className="form-label">
          Password
        </label>
        <input
          type="password"
          className="form-control rounded"
          id="password"
          placeholder="******"
          onChange={(e) => setPassword(e.target.value)}
        />
      </div>

      {error && <p className="fs-6 text-danger text-center">{error}</p>}

      <button type="submit" className="btn btn-dark w-100 rounded mb-3">
        Login
      </button>
      <Link to="/register" className="text-decoration-none fs-6 text-dark">
        No account? <span className="fw-bold">Create one</span>
      </Link>
    </form>
  );
}
