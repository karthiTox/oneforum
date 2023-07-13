export type Props = {
    children: React.ReactNode;
}

export function AuthContainer({ children }: Props) {
    return <div className="container d-flex justify-content-center align-items-center" style={{height: "80vh"}}>
        {children}
    </div>
}