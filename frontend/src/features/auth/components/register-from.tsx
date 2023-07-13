import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { AuthData } from "src/features/data";
import { useAxios } from "src/features/lib/use-axios";
import { useAuth } from "src/features/auth";

export function RegisterForm() {
  const navigate = useNavigate();
  const axios = useAxios();
  const auth = useAuth();

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [retypedPassword, setRetypedPassword] = useState("");  
  const [error, setError] = useState("");

  const onRegister = async () => {
    setError("");

    if (password.length < 6) {
      setError("password length shold be atleast 6 ");
      return;
    }

    if (password !== retypedPassword) {
      setError("password is not matching");
      return;
    }


    axios
      .post("/auth/register", {
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
        onRegister();
      }}
      className="text-center w-100"
      style={{
        maxWidth: "430px",
      }}
    >
      <h1 className="fs-3 mb-1 fw-bold">Let's get started!</h1>
      <p className="fs-6 mb-5">
        Enter your email address to create an account.
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

      <div className="mb-3 text-start">
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

      <div className="mb-5 text-start">
        <label htmlFor="password" className="form-label">
          Retype Password
        </label>
        <input
          type="password"
          className="form-control rounded"
          id="retypedpassword"
          placeholder="******"
          onChange={(e) => setRetypedPassword(e.target.value)}
        />
      </div>

      {error && <p className="fs-6 text-danger text-center">{error}</p>}

      <button type="submit" className="btn btn-dark w-100 rounded mb-3">
        Register
      </button>
      <Link to="/login" className="text-decoration-none fs-6 text-dark">
        Already have an account? <span className="fw-bold">Login</span>
      </Link>
    </form>
  );
}
